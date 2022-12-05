package org.etu.java.labs.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "intelligent_parking_system")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntelligentParkingSystem extends RepresentationModel<IntelligentParkingSystem> {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
        parameters = {
            @Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
        }
    )
    private String id;

    private String controlUnitModelName;
    private String onboardComputerModelName;
    private String electricPowerSteeringModelName;
    private String transmissionModelName;

    private String ultrasonicSensorsModelName;
    private Integer rearSensorsCount;
    private Integer frontSensorsCount;
    private Integer sideSensorsCount;

}
