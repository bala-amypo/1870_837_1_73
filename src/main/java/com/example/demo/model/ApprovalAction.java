@Entity
public class ApprovalAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;
    private Long approverId;

    // 🔴 MUST BE NAMED "level"
    private Integer level;

    private String action; // APPROVED / REJECTED
    private String comments;
    private LocalDateTime actionDate;
}
