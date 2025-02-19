package org.example.springjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@MappedSuperclass //Entity 부모역할
@EntityListeners(AuditingEntityListener.class) //이벤트 연결(binding), insert가 될 때 현재일시값을 넣자.
public class CreatedAt {
    @CreatedDate //insert가 되었을 때 현재일시값을 넣는다. 이 애노테이션이 작동을 하려면 @EntityListeners세팅이 되어 있어야 한다.
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 방법1 json변환시 해당 포멧으로 넣겠다. 단 이건 실제론 res부분에 넣어줘야 됨

    @Column(nullable = false, columnDefinition = "datetime(0)") //이 애노테이션은 자동으로 작성이 되는데 설정을 좀 더 해주고 싶다면 이 애노테이션을 붙여야 한다.
    private LocalDateTime createdAt;
}
