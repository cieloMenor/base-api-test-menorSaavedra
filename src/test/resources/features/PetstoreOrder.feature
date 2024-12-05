@PetstoreOrder
Feature: Petstore Order API

  Como un usuario de la API de Petstore
  Quiero obtener y eliminar órdenes
  Para poder gestionar los pedidos de la tienda de mascotas

  @CP01
  Scenario: Obtener una orden por ID exitosamente
    Given el actor establece el endpoint de la Petstore API
    When el actor envia una solicitud GET para la orden con id "5"
    Then el codigo de respuesta para la orden deberia ser 200

  @CP02
  Scenario: Eliminar una orden por ID exitosamente
    Given el actor establece el endpoint de la Petstore API
    When el actor envia una solicitud DELETE para la orden con id "5"
    Then el codigo de respuesta para la orden deberia ser 200