/*
 * package com.rs.app.feign;
 * 
 * import com.rs.app.request.VerificationRequest; import
 * org.springframework.cloud.openfeign.FeignClient; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import javax.validation.Valid;
 * 
 * 
 * @FeignClient("EMAIL-SERVICE") public interface ConnectEmailService {
 * 
 * @GetMapping("/email/welcome") public String welcomeEmail(@RequestParam @Valid
 * String toEmail, @RequestParam String name);
 * 
 * @GetMapping("/email/verify") public String
 * verificationEmail(@RequestBody @Valid VerificationRequest request); }
 */