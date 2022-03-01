package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/*

엔티티 매핑 관련 어노테이션

@Entity : 클래스를 엔티티로 선언

@Table : 엔티티와 매핑할 테이블을 지정

@Id : 테이블의 기본키에 사용할 속성을 지정
 - 기본키 : DB에서 조건을 만족하는 튜플을 찾을 때 다른 튜플들과 유일하게 구별할 수 있도록 기준을 세워주는 속성

@GeneratedValue : 키 값을 생성하는 전략 명시
 -GenerationType.AUTO : JPA 구현체가 자동으로 생성 전략 결정
 -GenerationType.IDENTITY : 기본키 생성을 데이터베이스에 위임
 -GenerationType.SEQUENCE : 데이터베이스 시퀀스 오브젝트를 이용한 기본키 생성
 -GenerationType.TABLE : 키 생성욜 테이블 사용

@Column : 필드와 컬럼 매핑
 -name : 필드와 매핑할 컬럼의 이름 설정
 -unique(DDL) : 유니크 제약 조건 설정
 -insertable : insert 가능 여부
 -updatable : update 가능 여부
 -length: String 타입의 문자 길이 제약조건 설정
 -nullable : null 값의 허용 여부 설정
 -columnDefinition : 데이터베이스의 컬럼 정보 직접 기술

@Lob : BLOB, CLOB 타입 매핑
 -CLOB : 사이즈가 큰 데이터를 외부 파일로 저장히기 위한 데이터 타입
 -BLOB : 바이너리 데이터를 DB 외부에 저장하기 위한 타입

@CreationTimestamp : insert 시 시간 자동 저장

@UpdateTimestamp : update 시 시간 자동 자정

@Enumerated : enum 타입 매핑

@Transient : 해당 필드 데이터베이스 매핑 무시

@Temporal : 날짜 타입 매핑

@CreateDate : 엔티티가 생성되어 저장될 때 시간 자동 저장

@LastModifiedDate : 조회한 엔티티의 값을 변경할 때 시간 자동 저장

*/

@Entity     // Item 클래스를 entity로 선언
@Table(name ="item")    // item 테이블과 매핑되도록 name을 item으로 지정
@Getter
@Setter
@ToString
public class Item {

    @Id     // entity로 선언한 클래스는 반드시 기본키를 가져야 하는데, 기본키가 되는 멤버변수에 @Id를 붙인다.
    @Column(name="item_id")     // 테이블에 매핑될 컬럼의 이름을 설정한다.
    @GeneratedValue(strategy = GenerationType.AUTO)     // 기본키 생성 전략을 AUTO로 지정
    private Long id;    // 상품 코드

    @Column(nullable = false, length = 50)  // nullable 속성을 이용해서 항상 값이 있어야 하는지 설정 필요한 길이를 50으로 설정
    private String itemNm;  // 상품명

    @Column(name="price" , nullable = false)
    private int price;  // 가격

    @Column(nullable = false)
    private int stockNumber;    // 재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;     // 상품 판매 상태

    private LocalDateTime regTime;  // 등록 시간

    private LocalDateTime updateTime;   // 수정 시간
}
