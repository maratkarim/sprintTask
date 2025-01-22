package kz.bitlab.practiceTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private Long id;
    private String name;
    private String deadlineDate;
    private boolean isCompleted;
}
