package juliocoder.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    /**
     * METODOS GET
     * segundo recurso despues de bookings... muestra todos los valores de booking, listado de hoteles sin ningun filtro
     * @return a definir
     */
    @RequestMapping (value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    /**
     * METODO GET CON FILTRO Filtro para mostrar hoteles segun valores ofertados,
     * metodo que retornara HotelBookings, aplicando metodo get se agrega puntero con pathvariable validando segun precio
     * @param price filtro, aplicado al precio por noche
     * @return a definir
     */

    @RequestMapping(value = "affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookingRepository.findByPricePerNightsLessThan(price);
        //return bookings.stream().filter(x -> x.getPricePerNights() <= price).collect(Collectors.toList());
    }

    /**
     * METODOS POST
     * Requestbody, busca inicializar el metodo post,
     * en spring esto deberia crear automaticamente un nuevo objeto basado en un json que este dentro del recurso
     * @param hotelBooking a definir
     * @return a definir
     * /*Es muy imporatnte cuando usamos RequestBody y se crea     nuevos objetos, revisar el constructor que usamos, revisar si esta por defecto que pueda absorver los nuevos objetos
     */

    @RequestMapping (value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);

        return bookingRepository.findAll();
    }



    /**
     * Recurso DELETE usando el metodo get.
     * se creo el metodo delete(id) en el BookingRepository con puntero sobre long id.
     * @param id a defninr
     * @return a deinir
     */

    @RequestMapping (value = "/delete/{id}", method = RequestMethod.GET)
    public List<HotelBooking> remove(@PathVariable long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
