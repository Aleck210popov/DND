package org.example.data;

import lombok.experimental.UtilityClass;

import javax.swing.*;
import java.util.*;

@UtilityClass
public class InitializationDataUtils {


        public List<Figure> initializationData() {
            return Arrays.asList(
                    // Фентези, Мужской, Паладин, Аасимар
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image1.jpg"))))
                            .name("Левистий")
                            .gender(Gender.MALE)
                            .playerClass(PlayerClass.PALADIN)
                            .worldSetting(WorldSetting.FANTASY)
                            .race(Race.AASIMAR)
                            .build(),

                    // Фентези, Женский, Паладин, Аасимар
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image2.jpg"))))
                            .name("Леандра")
                            .gender(Gender.FEMALE)
                            .playerClass(PlayerClass.PALADIN)
                            .worldSetting(WorldSetting.FANTASY)
                            .race(Race.AASIMAR)
                            .build(),

                    // Фентези, Женский, Маг, Человек
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image3.jpg"))))
                            .name("Сара")
                            .gender(Gender.FEMALE)
                            .playerClass(PlayerClass.MAGE)
                            .worldSetting(WorldSetting.FANTASY)
                            .race(Race.HUMAN)
                            .build(),

                    // Фентези, Мужской, Маг, Человек
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image4.jpg"))))
                            .name("Рейнлард")
                            .gender(Gender.MALE)
                            .playerClass(PlayerClass.MAGE)
                            .worldSetting(WorldSetting.FANTASY)
                            .race(Race.HUMAN)
                            .build(),

                    // Киберпанк, Женский, Воин, Человек
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image5.jpg"))))
                            .name("Кай")
                            .gender(Gender.FEMALE)
                            .playerClass(PlayerClass.WARRIOR)
                            .worldSetting(WorldSetting.CYBERPUNK)
                            .race(Race.HUMAN)
                            .build(),

                    // Киберпанк, Женский, Воин, Человек
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image6.jpg"))))
                            .name("Яцуке")
                            .gender(Gender.FEMALE)
                            .playerClass(PlayerClass.WARRIOR)
                            .worldSetting(WorldSetting.CYBERPUNK)
                            .race(Race.HUMAN)
                            .build(),

                    // Фентези, Мужской, Паладин, Драконорожденный
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image7.jpg"))))
                            .name("Мориарт")
                            .gender(Gender.MALE)
                            .playerClass(PlayerClass.PALADIN)
                            .worldSetting(WorldSetting.FANTASY)
                            .race(Race.DRACONBORN)
                            .build(),

                    // Фентези, Женский, Паладин, Драконорожденный
                    Figure.builder()
                            .urlImage(new ImageIcon(Objects.requireNonNull(InitializationDataUtils.class.getResource("/image8.jpg"))))
                            .name("Араксис")
                            .gender(Gender.FEMALE)
                            .playerClass(PlayerClass.PALADIN)
                            .worldSetting(WorldSetting.FANTASY)
                            .race(Race.DRACONBORN)
                            .build()
            );
        }
}