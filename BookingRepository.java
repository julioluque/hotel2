package juliocoder.bookingdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <HotelBooking, Long> {

    /**
     * creamos el metodo findByPricePerNightsLessThan para que el controller lo pueda leer y lo tome como clase.
     * se leera en el recurso /affordable/{price} del GET
     * @param price damos los valores price que es sobre los qeu actuaremos.
     * @return
     */
    List<HotelBooking> findByPricePerNightsLessThan(double price);


    /**
     * creamos el metodo delete con un puntero en ID ya que no existia en la libreria
     * este se leera a travez del @PathVariable e ingresando el valor de id podremos actualizar o elminar en este caso.
     * Se lee en el metodo DELETE
     * @param id
     * @return
     */
    List<HotelBooking> deleteById(long id);

}
