@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user, String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName(roleName);
                    return roleRepository.save(r);
                });

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(role);

        return userRepository.save(user);
    }

    @Override
    public boolean validatePassword(String raw, String encoded) {
        return passwordEncoder.matches(raw, encoded);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
