package exercise.bc.wechat.mp;

import com.alibaba.fastjson.JSON;
import exercise.bc.wechat.mp.ut.*;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class MpController {

    private static WXBizMsgCrypt wxBizMsgCrypt;

    {
        try {
            wxBizMsgCrypt = new WXBizMsgCrypt("KAOc4ip", "QK0e0u1RSAgXD5bsBk5WtQnvgPBDdWQ8w9Moq9LP7kN", "wwfede9a1cdac68225");
        } catch (AesException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述:
     * 应用详情 --> 使用配置 --> 业务设置URL
     * 当安装应用时
     * 该接口 并行判断是否是设置回调 还是请求授权 可直接获取到 token --> 2h
     *
     * @param msg_signature 1
     * @param timestamp     2
     * @param nonce         3
     * @param echostr       4
     * @param request       5
     * @param response      6
     * @return : java.lang.String
     * @author : blackCat
     * @date : 2019/5/21 12:54
     */
    @RequestMapping("/suite/receive")
    public String suite(@RequestParam("msg_signature") String msg_signature,
                        @RequestParam("timestamp") String timestamp,
                        @RequestParam("nonce") String nonce,
                        @RequestParam(value = "echostr", required = false) String echostr,
                        HttpServletRequest request,
                        HttpServletResponse response) throws AesException, IOException {
        System.out.println("指令回调URL-微信调用我了");

        if (null != echostr) {
            return verifyUrl(msg_signature, timestamp, nonce, echostr);
        }
        BufferedReader reader = request.getReader();
        StringBuffer buffer = new StringBuffer();
        String line = " ";
        while (null != (line = reader.readLine())) {
            buffer.append(line);
        }

        String postData = buffer.toString();
        System.out.println("postData:" + postData);

        String decryptMsgs = wxBizMsgCrypt.DecryptMsg(msg_signature, timestamp, nonce, postData);
        System.out.println("decryptMsgs:" + decryptMsgs);
        // 获取token
        getSuiteToken(decryptMsgs);
        return "success";
    }

    /**
     * 功能描述:
     * 获取 token -->2h
     *
     * @param decryptMsgs 1
     * @return : void
     * @author : blackCat
     * @date : 2019/5/21 14:00
     */
    private void getSuiteToken(String decryptMsgs) {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token";
        JSONObject jsonObject = XML.toJSONObject(decryptMsgs.replace("<xml>", "").replace("</xml>", ""));

        Suite suite = new Suite();
        suite.setSuite_id(jsonObject.get("SuiteId").toString());
        suite.setSuite_secret("uLfdRkSCPOKqRfuKll2ZG5Uk0OfQZ8aX0t1vNb9WbUs");
        suite.setSuite_ticket(jsonObject.get("SuiteTicket").toString());

        com.alibaba.fastjson.JSONObject re = HttpUt.sendPost(url, JSON.toJSONString(suite));
        SuiteR suiteR = JSON.toJavaObject(re, SuiteR.class);
        System.out.println("suiteR:" + suiteR.toString());
    }

    /**
     * 功能描述:
     * 应用详情 --> 使用配置 --> 业务设置URL
     *
     * @param msg_signature 1
     * @param timestamp     2
     * @param nonce         3
     * @param echostr       4
     * @return : java.lang.String
     * @author : blackCat
     * @date : 2019/5/21 12:53
     */
    @RequestMapping("/service")
    public String service(@RequestParam("msg_signature") String msg_signature,
                          @RequestParam("timestamp") String timestamp,
                          @RequestParam("nonce") String nonce,
                          @RequestParam("echostr") String echostr) {
        System.out.println("业务设置URL-微信调用我了");

        return verifyUrl(msg_signature, timestamp, nonce, echostr);
    }

    /**
     * 功能描述:
     * 应用详情 --> 回调配置中 --> 数据回调URL
     *
     * @param msg_signature 1
     * @param timestamp     2
     * @param nonce         3
     * @param echostr       4
     * @return : java.lang.String
     * @author : blackCat
     * @date : 2019/5/21 12:52
     */
    @RequestMapping("/data")
    public String data(@RequestParam("msg_signature") String msg_signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("echostr") String echostr) {
        System.out.println("数据回调URL-微信调用我了");

        return verifyUrl(msg_signature, timestamp, nonce, echostr);
    }

    /**
     * 功能描述:
     * 配置通用开发时调用
     * 注:wxBizMsgCrypt 这个构造方法的Token、EncodingAESKey参数要为通用开发参数的
     *
     * @param msg_signature 1
     * @param timestamp     2
     * @param nonce         3
     * @param echostr       4
     * @return : java.lang.String
     * @author : blackCat
     * @date : 2019/5/21 12:50
     */
    @GetMapping("secc")
    public String secc(@RequestParam("msg_signature") String msg_signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("echostr") String echostr) {

        return verifyUrl(msg_signature, timestamp, nonce, echostr);
    }

    /**
     * 功能描述:
     * 配置回调时调用 该接口进行url校验 解密echostr明文返回
     *
     * @param msg_signature 1
     * @param timestamp     2
     * @param nonce         3
     * @param echostr       4
     * @return : java.lang.String
     * @author : blackCat
     * @date : 2019/5/21 12:49
     */
    private String verifyUrl(String msg_signature, String timestamp, String nonce, String echostr) {
        try {
            System.err.println(msg_signature + "-|-" + timestamp + "-|-" + nonce + "-|-" + echostr);
            String s = wxBizMsgCrypt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            return s;
        } catch (AesException e) {
            e.printStackTrace();
        }
        return null;
    }
}
