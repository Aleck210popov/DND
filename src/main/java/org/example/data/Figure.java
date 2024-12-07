package org.example.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Figure {

    private ImageIcon urlImage;

    private String name;

    private Gender gender;

    private PlayerClass playerClass;

    private WorldSetting worldSetting;

    private Race race;

    public boolean matches(Figure other) {
        // Проверяем, соответствует ли данная фигура выбранным атрибутам
        return (this.worldSetting.equals(other.getWorldSetting()) &&
                this.gender.equals(other.getGender()) &&
                this.playerClass.equals(other.getPlayerClass()) &&
                this.race.equals(other.getRace()));
    }
}
