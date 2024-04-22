package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("filledService")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilledService {
    @Id
    private String id;
    private String formHash;
}
