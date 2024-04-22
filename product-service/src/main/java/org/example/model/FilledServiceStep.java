package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("filledService")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilledServiceStep {
    @Id
    private String id;
    private Object filledStepJson;
    private String filledServiceId;
}
