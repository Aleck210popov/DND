package org.example.ui;

import org.example.data.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrameMain extends JFrame {

    private final List<Figure> figureList;
    private final JPanel panelMaster;

    private final JPanel panelQuestion;

    private final JPanel panelImage;

    private final JTextArea questionTextArea;

    private final JComboBox<Attr> figureJComboBox;

    private final JLabel imageLabel;

    private JLabel nameLabel;
    private static FrameMain singletonFrameMain;

    private Figure selectedFigure; // Храним выбранного персонажа
    private int questionIndex = 0; // Индекс текущего вопроса

    private WorldSetting selectedWorldSetting;
    private Gender selectedGender;
    private PlayerClass selectedPlayerClass;
    private Race selectedRace;
    private boolean isProcessing = false;

    {
        panelMaster = new JPanel();
        this.add(panelMaster);
        this.setSize(1600, 700);
        panelMaster.setBorder(BorderFactory.createLineBorder(Color.black));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelMaster.setLayout(new GridLayout(1, 2));
    }

    private FrameMain(){
        super("Главное меню");
        figureList = InitializationDataUtils.initializationData(); // Заполняем список фигур
        panelQuestion = new JPanel();
        panelQuestion.setVisible(true);
        panelQuestion.setLayout(new GridLayout(2,1));
        panelImage = new JPanel();
        panelImage.setVisible(true);
        panelImage.setLayout(new BorderLayout());
        panelMaster.add(panelQuestion);
        panelMaster.add(panelImage);

        questionTextArea = new JTextArea();
        figureJComboBox = new JComboBox<>();
        imageLabel = new JLabel();
        nameLabel = new JLabel();

        panelQuestion.add(questionTextArea);
        panelQuestion.add(figureJComboBox);
        panelImage.add(imageLabel, BorderLayout.CENTER);
        panelImage.add(nameLabel, BorderLayout.SOUTH);

        // Инициализация первого вопроса
        showNextQuestion();
    }

    public static FrameMain getSingleton() {
        if (singletonFrameMain == null) {
            singletonFrameMain = new FrameMain();
        }
        return singletonFrameMain;
    }

    private void showNextQuestion() {
        if (questionIndex >= 4) {
            // Если вопросы завершены, фильтруем и показываем результат
            filterFigures();
            return;
        }

        switch (questionIndex) {
            case 0: // Вопрос о WorldSetting
                questionTextArea.setText("Выберите Setting:");
                // Очищаем ComboBox перед добавлением новых значений
                figureJComboBox.removeAllItems();
                // Добавляем все элементы из WorldSetting
                for (WorldSetting setting : WorldSetting.values()) {
                    figureJComboBox.addItem(setting);
                }
                break;
            case 1: // Вопрос о Поле (Gender)
                questionTextArea.setText("Выберите Пол:");
                // Очищаем ComboBox перед добавлением новых значений
                figureJComboBox.removeAllItems();
                // Добавляем все элементы из Gender
                for (Gender gender : Gender.values()) {
                    figureJComboBox.addItem(gender);
                }
                break;
            case 2: // Вопрос о Классе (PlayerClass)
                questionTextArea.setText("Выберите Класс:");
                // Очищаем ComboBox перед добавлением новых значений
                figureJComboBox.removeAllItems();
                // Добавляем все элементы из PlayerClass
                for (PlayerClass playerClass : PlayerClass.values()) {
                    figureJComboBox.addItem(playerClass);
                }
                break;
            case 3: // Вопрос о Расе (Race)
                questionTextArea.setText("Выберите Расу:");
                // Очищаем ComboBox перед добавлением новых значений
                figureJComboBox.removeAllItems();
                // Добавляем все элементы из Race
                for (Race race : Race.values()) {
                    figureJComboBox.addItem(race);
                }
                break;
        }

        // Флаг, чтобы предотвратить повторное выполнение обработчика


        // Обработчик события выбора в JComboBox
        figureJComboBox.addActionListener(e -> {


            // Если уже обрабатываем выбор, выходим
            if (isProcessing) {
                return;
            }

            // Устанавливаем флаг, что обработка идет
            isProcessing = true;

            Attr selectedValue = (Attr) figureJComboBox.getSelectedItem();

            // Проверка, выбран ли элемент
            if (selectedValue == null) {
                isProcessing = false;  // Сбрасываем флаг
                return; // Возвращаемся, если ничего не выбрано
            }

            int option = JOptionPane.showConfirmDialog(this, "Вы выбрали: " + selectedValue.getDescription(), "Подтвердить выбор", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // В зависимости от текущего вопроса обновляем атрибуты
                switch (questionIndex) {
                    case 0:
                        selectedWorldSetting = (WorldSetting) selectedValue;
                        break;
                    case 1:
                        selectedGender = (Gender) selectedValue;
                        break;
                    case 2:
                        selectedPlayerClass = (PlayerClass) selectedValue;
                        break;
                    case 3:
                        selectedRace = (Race) selectedValue;
                        break;
                }

                // Переход к следующему вопросу
                questionIndex++;

                // Проверяем, если есть следующий вопрос, обновляем ComboBox
                if (questionIndex < 4) {
                    // Сначала очищаем ComboBox
                    figureJComboBox.removeAllItems();

                    // Устанавливаем новые элементы для ComboBox
                    showNextQuestion(); // Переход к следующему вопросу
                } else {
                    filterFigures(); // Если вопросы завершены, фильтруем и показываем результат
                }
            }

            // Сбрасываем флаг, что обработка завершена
            isProcessing = false;
        });

    }

    private void filterFigures() {
        boolean found = false;

        // Фильтруем список фигур по выбранным атрибутам
        for (Figure figure : figureList) {
            // Проверяем совпадение всех атрибутов
            if (figure.getWorldSetting() == selectedWorldSetting &&
                    figure.getGender() == selectedGender &&
                    figure.getPlayerClass() == selectedPlayerClass &&
                    figure.getRace() == selectedRace) {
                // Если найден подходящий персонаж, показываем его
                imageLabel.setIcon(figure.getUrlImage());
                nameLabel.setText(figure.getName());
                found = true;
                break;
            }
        }

        // Если не найдено подходящего персонажа
        if (!found) {
            nameLabel.setText("Нет подходящего персонажа");
        }
    }
}