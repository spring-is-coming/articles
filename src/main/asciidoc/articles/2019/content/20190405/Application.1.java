@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    @AllArgsConstructor
    public class UserLoader implements ApplicationRunner /* <1> */ {
        private PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;

        public void run(ApplicationArguments args) {
            userRepository.save(User.builder().login("ykl").password(passwordEncoder.encode("ykl")).withAuthority("USER").build());
        }
    }
}