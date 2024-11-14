package com.example.shoppingpayment.users.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/*
    모든 필드의 이름을 camelCase로 변경. (예: users_id -> usersId).
    이는 Java 명명 규칙을 따르기 위함이며, @Column(name = "...") 을 통해 실제 데이터베이스 컬럼 이름은 원래대로 유지됨.
*/

// @Table(name = "users")을 통해 테이블 이름을 명시적으로 지정.
@Setter
@Getter
@Entity
@Table(name = "users")
public class Users {
    /*
        @GeneratedValue(strategy = GenerationType.IDENTITY)는 데이터베이스의 AUTO_INCREMENT 기능 구현.
        nullable = false를 통해 NOT NULL 제약조건을 설정.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", nullable = false)
    private Long usersId;

    // 필드에 length 속성을 추가하여 VARCHAR 길이를 지정.
    @Column(name = "users_name", nullable = false, length = 50)
    private String usersName;

    @Column(name = "users_password", nullable = false, length = 255)
    private String usersPassword;

    @Column(name = "users_email", nullable = false, length = 100)
    private String usersEmail;

    /*
        @CreationTimestamp 어노테이션을 추가하여 엔티티가 생성될 때 자동으로 현재 시간이 설정되도록 정함.
        updatable = false를 추가하여 생성 후 수정되지 않도록 함.
        LocalDate에서 LocalDateTime으로 변경하여 DATETIME 타입에 맞춤.
    */

    @CreationTimestamp
    @Column(name = "users_created_at", nullable = false, updatable = false)
    private LocalDateTime usersCreatedAt;

}
