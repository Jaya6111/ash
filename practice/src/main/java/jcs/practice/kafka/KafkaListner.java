/*
 * package jcs.practice.kafka;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.kafka.annotation.KafkaListener; import
 * org.springframework.kafka.core.KafkaTemplate; import
 * org.springframework.stereotype.Component;
 * 
 * import com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * import jcs.practice.entity.User; import jcs.practice.service.DemoService;
 * 
 * @Component public class KafkaListner {
 * 
 * public static final String DELETE_USER = "deleteUser";
 * 
 * public static final String SINGLE_USER = "singleUser";
 * 
 * public static final String ALL_USERS = "allUsers";
 * 
 * @Autowired private DemoService service;
 * 
 * @Autowired private KafkaTemplate<String, Object> kafkaTemplate;
 * 
 * private final ObjectMapper objectMapper = new ObjectMapper();
 * 
 * @KafkaListener(topics = { ALL_USERS, SINGLE_USER, DELETE_USER }, groupId =
 * ("practice-group")) public void listner(String message) throws
 * JsonProcessingException { String json = "", sid = "", value = ""; int id = 0;
 * 
 * if (message.contains("-")) { String s[] = message.split("-"); sid = s[1]; id
 * = Integer.parseInt(sid); value = s[0]; } value = value.equals(ALL_USERS) ?
 * "multipleUsers" : value.equals(SINGLE_USER) ? "oneUser" :
 * value.equals(DELETE_USER)?"noUser" : ""; if (message.contains(ALL_USERS)) {
 * List<User> users = service.getAllUsers(); if (users == null ||
 * users.isEmpty()) users = new ArrayList<User>(); json =
 * objectMapper.writeValueAsString(users); json = json + "-" + "multipleUsers";
 * kafkaTemplate.send("multipleUsers", json); } else if
 * (message.contains(SINGLE_USER)) { User user = service.getUser(id); if (user
 * == null) user = new User(); json = objectMapper.writeValueAsString(user);
 * json = json + "-" + value; kafkaTemplate.send("oneUser", json); } else if
 * (message.contains(DELETE_USER)) { try { service.deleteUser(id); json =
 * "User with Id: " + id + "deleted successfully"; } catch (Exception e) { json
 * = "User with Id: " + id + "is not exist in the database"; } json = json + "-"
 * + value; kafkaTemplate.send("noUser", json); }
 * System.out.println("message from security: " + message +
 * "\nreturning to security: " + json); }
 * 
 * }
 */