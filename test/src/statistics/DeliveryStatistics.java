/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

/**
 *
 * @author Lenovo
 */


import models.Livraison;
import java.util.List;

public class DeliveryStatistics {
    public static int calculateTotalDeliveries(List<Livraison> deliveries) {
        return deliveries.size();
    }

    public static int calculateDeliveriesInTransit(List<Livraison> deliveries) {
        int inTransitCount = 0;
        for (Livraison delivery : deliveries) {
            if (delivery.getStatus().equals("In Transit")) {
                inTransitCount++;
            }
        }
        return inTransitCount;
    }

    public static int calculateDeliveredDeliveries(List<Livraison> deliveries) {
        int deliveredCount = 0;
        for (Livraison delivery : deliveries) {
            if (delivery.getStatus().equals("Delivered")) {
                deliveredCount++;
            }
        }
        return deliveredCount;
    }

    // Add more statistics calculation methods as needed
}
