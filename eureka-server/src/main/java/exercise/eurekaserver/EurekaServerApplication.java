package exercise.eurekaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author BlackCat
 * @Description //TODO 注册中心
 * @Date 9:18 2019/3/27
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	private static final Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
		StringBuffer sb = new StringBuffer("                       .::::.\n");
		sb.append("                     .::::::::.\n")
				.append("                    :::::::::::\n")
				.append("                 ..:::::::::::'\n")
				.append("              '::::::::::::'\n")
				.append("                .::::::::::\n")
				.append("           '::::::::::::::..\n")
				.append("                ..::::::::::::.\n")
				.append("              ``::::::::::::::::\n")
				.append("               ::::``:::::::::'        .:::.\n")
				.append("              ::::'   ':::::'       .::::::::.\n")
				.append("            .::::'      ::::     .:::::::'::::.\n")
				.append("           .:::'       :::::  .:::::::::' ':::::.\n")
				.append("          .::'        :::::.:::::::::'      ':::::.\n")
				.append("         .::'         ::::::::::::::'         ``::::.\n")
				.append("     ...:::           ::::::::::::'              ``::.\n")
				.append("    ```` ':.          ':::::::::'                  ::::..\n")
				.append("                       '.:::::'                    ':'````..\n")
				.append("                     beauty Bless, No Bug !                ");
		logger.info(sb.toString());
	}

}
