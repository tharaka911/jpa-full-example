package com.inactcode.jpafullexample.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course" )


public class CourseMaterial {

    @SequenceGenerator(name ="course_material_sequence" ,sequenceName ="course_material_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")

    @Id
    private Long courseMateriaId;

    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;

}
