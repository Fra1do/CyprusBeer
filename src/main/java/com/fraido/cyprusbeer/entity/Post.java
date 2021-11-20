package com.fraido.cyprusbeer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "title")
   private String title;

   @Column(name = "description")
   private String description;

   @ManyToOne (optional=false, cascade = CascadeType.ALL)
   @JoinColumn (name="user_id")
   private User user;
}
