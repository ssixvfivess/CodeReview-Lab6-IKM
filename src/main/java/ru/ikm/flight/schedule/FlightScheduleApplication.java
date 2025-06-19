package ru.ikm.flight.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Главный класс Spring Boot приложения "Расписание рейсов".
 *
 * <p>Содержит точку входа в приложение и выполняет его конфигурацию.</p>
 *
 * <h3>Основные функции:</h3>
 * <ul>
 *   <li>Запускает Spring Boot приложение</li>
 *   <li>Автоматически настраивает компоненты Spring</li>
 *   <li>Активирует сканирование JPA репозиториев в указанном пакете</li>
 *   <li>Загружает все необходимые бины и конфигурации</li>
 * </ul>
 */
@SpringBootApplication
@EnableJpaRepositories("ru.ikm.flight.schedule.repository")
public class FlightScheduleApplication {

	/**
	 * Точка входа в приложение.
	 *
	 * @param args аргументы командной строки
	 *
	 * <h3> ✈ Сайт Аэропорта "Дрямино":</h3>
	 * <pre>{@code
	 * http://localhost:8090/index.html
	 * }</pre>
	 */
	public static void main(String[] args) {
		SpringApplication.run(FlightScheduleApplication.class, args);
	}
}