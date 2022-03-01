package com.shop.controller;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
// url에 "/thymeleaf" 경로로 오는 요청을 ThymeleafExController가 처리하도록 한다
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController {

    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model){
        // model 객체를 이용해 뷰에 전달한 데이터를 key, value 구조로 넣어준다.
        // key값이 data인 value에 attributeValue를 할당한다.
        model.addAttribute("data", "타임리프 예제 입니다!!");
        // templates 폴더를 기준으로 뷰의 위치와 이름을 반환한다.
        return "thymeleafEx/thymeleafEx01";
    }

    // thymeleaf 문법으로 객체를 전달
    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model){

        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        // value로 객체를 전달
        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }

    // thymeleaf 문법으로 리스트를 전달하여 여러 개의 값을 출력할 수 있도록 함
    @GetMapping(value = "/ex03")
    public String thymeleafExample03(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i = 1; i<= 10; i++){

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        // itemDtoList를 model에 담아서 View에 전달
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx03";
    }

    @GetMapping(value = "/ex04")
    public String thymeleafExample04(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i = 1; i<= 10; i++){

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList" , itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }

    @GetMapping(value = "/ex05")
    public String thymeleafExample05(){
        return "thymeleafEx/thymeleafEx05";
    }

    // a 태그에 변수를 전달해야 할 경우
    @GetMapping(value = "/ex06")
    public String thymeleafExample06(String param1, String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleafEx/thymeleafEx06";
    }

    @GetMapping(value = "/ex07")
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }
}



























