@Passengers
Feature: API Pasajeros

  Como un usuario de la API de pasajeros
  Quiero obtener y crear información de pasajeros
  Para poder gestionar los datos de los pasajeros

  @CP01
  Scenario: Obtener todos los pasajeros exitosamente
    Given el actor establece el endpoint para obtener los pasajeros
    When el actor envia una solicitud GET a pasajeros
    Then el codigo de respuesta para el pasajero deberia ser 200

  @CP02
  Scenario Outline: Obtener un pasajero por ID
    Given el actor establece el endpoint para obtener los pasajeros
    When el actor envia una solicitud GET al pasajero con id "<id>"
    Then el codigo de respuesta para el pasajero deberia ser <codigo>

    Examples:
      | id | codigo |
      | 1  | 200    |
      | 0  | 204    |