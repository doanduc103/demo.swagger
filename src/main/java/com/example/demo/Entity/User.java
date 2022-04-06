package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acc")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "Username",required = true,example = "Đoàn Đức")
    @Column(name = "name")
    private String name;
    @ApiModelProperty(value = "Email",required = true,example = "doanduc10393@gmail.com")
    @Column(name = "email")
    private String email;
    @ApiModelProperty(value = "Phonenumber",required = true,example = "123456789")
    @Column(name = "phone")
    private String phone;
    @Column(name = "avatar")
    private String avatar;
    @ApiModelProperty(value = "Password", required = true, example = "Duc123456")
    @Column(name = "pass")
    private String password;
}
