package zti.FilmNet.model;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "streaming_platforms")
public class StreamingPlatform {
    @Id
    @Column(name = "streaming_platform_name")
    private String name;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "cost")
    private String cost;
}
