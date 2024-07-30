/*
 * package jcs.practice.config;
 * 
 * import org.apache.kafka.clients.admin.NewTopic; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.kafka.config.TopicBuilder;
 * 
 * import jcs.practice.constants.AppConstant;
 * 
 * @Configuration public class KafkaConfig {
 * 
 * @Bean public NewTopic allUserTopic() { return
 * TopicBuilder.name(AppConstant.ALL_USERS).build(); }
 * 
 * @Bean public NewTopic singleUserTopic() { return
 * TopicBuilder.name(AppConstant.SINGLE_USER).build(); }
 * 
 * @Bean public NewTopic deleteUserTopic() { return
 * TopicBuilder.name(AppConstant.DELETE_USER).build(); } }
 */