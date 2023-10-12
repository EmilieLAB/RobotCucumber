Feature: Consommation Energie
  La charge de départ du robot et de 20 unités.
  Le robot consomme de l'énergie à chaque déplacement en fonction du terrain.
  Le robot récupère de l'énergie lorsqu'il ne bouge pas et que ses panneaux solaires sont déployés.

  Scenario: Charge de départ
    Given Le robot est en vol
    When le robot atterrit en coordonnée (6, 5)
    Then la charge du robot est de 20 unités

  Scenario: Charge insuffisante
    Given Le robot est en vol
    When le robot atterrit en coordonnée (6, 5)
    And le robot se déplace en coordonnée (9, 9)
    Then les coordonnées du robot sont (9, 8)
    And la charge du robot est de 0 unités

  Scenario: Le robot se recharge
    Given Le robot est en vol
    When le robot atterrit en coordonnée (6, 5)
    And le robot ne fait rien pendant 10 secondes
    Then la charge du robot est de 120 unités
