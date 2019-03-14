package juliocoder.bookingdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * clases usadas como ficha de informacion
 * creado por julio
 */

@Entity
public class HotelBooking {

    /**
     * Long id, genera la secuencia de ids.id property.
     */
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)   // generar secuencia, 1, 2, 3 etc...
    private long id;   //id property

    private String hotelName;
    private double pricePerNights;
    private int nbOfNights;

    /**
     * este es un constructor vacio que absorve los nuevos datos cargados.
     */
    public HotelBooking(){}


    /**
     * Este es un construtor para inicializar el objeto hotel booking
     * @param hotelName Inicial para nombre del hotel
     * @param pricePerNights inicial para precio por noche
     * @param nbOfNights tiempo de estadia en dias
     */
    public HotelBooking(String hotelName, double pricePerNights, int nbOfNights){
        this.hotelName = hotelName;
        this.pricePerNights = pricePerNights;
        this.nbOfNights = nbOfNights;
    }

    /**
     * Muestra nuevo nombre de hotel
     * @return nombre del hotel
     */
    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNights() {
        return pricePerNights;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    /**
     * Calcula la estadia completa
     * @return precio segun cantidad de noches.
     */
    public double getTotalPrice(){
        return pricePerNights * nbOfNights;
    }

    public long getId() {
        return id;
    }
}