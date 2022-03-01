package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository 는 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정의되어 있다.

/*

JpaRepository 에서 지원하는 메소드 예시

<S extends T> save(S entity) : 엔티티 저장 및 수정
void delete(T entity) : 엔티티 삭제
count() : 엔티티 총 개수 반환
Iterable<T> findAll() : 모든 엔티티 조회
 */

/*

QueryDslPredicateExecutor 인터페이스에서 제공하는 메서드

long count(Predicate) : 조건에 맞는 데이터의 총 개수 반환
boolean exists(Predicate) : 조건에 맞는 데이터 존재 여부 반환
Iterable findAll(Predicate) : 조건에 맞는 모든 데이터 반환
Page<T> findAll(Predicate, Pageable) : 조건에 맞는 페이지 데이터 반환
Iterable findAll(Predicate, Sort) : 조건에 맞는 정렬된 데이터 반환
T findOne(Predicate) : 조건에 맞는 데이터 1개 반환
 */

public interface ItemRepository extends JpaRepository<Item, Long> , QuerydslPredicateExecutor<Item>{

    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // @Query 안에 JPQL로 작성한 쿼리문을 넣는다.
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    // @Param을 이용하여 파라미터로 넘어온 값을 JPQL에 들어갈 변수로 지정할 수 있다.
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // 기존의 데이터베이스에서 사용하던 쿼리를 그대로 해용해야 할 때는 nativeQuery를 true로 설정하면 된다.
    @Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

}
