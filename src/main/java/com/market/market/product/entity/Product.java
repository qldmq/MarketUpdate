package com.market.market.product.entity;

import java.util.Date;

import javax.persistence.*;

import com.market.market.member.dto.MemberDto;
import com.market.market.member.entity.Member;
import com.market.market.product.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_seq;

    @Column(length = 30)
    private String title;

    @Column(length = 300)
    private String content;

    @Column
    private Date reg_date;

    @Column(columnDefinition = "TEXT")
    private String product_image;

    @Column
    private int view_cnt;

    @Column
    private int like_cnt;

    @Column
    private int price;

    @Column
    private String address;

    @Column
    private String jibun_address;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private int product_status;

    @Column(length = 100)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",nullable=false)
    private Member member;


    public static Product toEntity(ProductDto dto, Member member){       
        String imagePath = "";
        String category = "";

        try {          
           if (dto.getCategory() != null){
               category = dto.getCategory().toString();
           }

           if(dto.getProduct_image() != null){
               imagePath = dto.getProduct_image().toString();
           }

       } catch (Exception e) {
           System.out.println("Error Message : "+e.getMessage());           
       }

       return Product.builder()
       .title(dto.getTitle())
       .content(dto.getContent())
       .reg_date(dto.getReg_date())
       .product_image(imagePath)
       .view_cnt(dto.getView_cnt())
       .like_cnt(dto.getLike_cnt())
       .price(dto.getPrice())
       .address(dto.getLocation().getAddress())
       .jibun_address(dto.getLocation().getJibun_address())
       .latitude(dto.getLocation().getLatitude())
       .longitude(dto.getLocation().getLongitude())
       .product_status(dto.getProduct_status())
       .category(category)
       .member(member)
       .build();
    }

}
