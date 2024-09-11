import dao.AppointmentDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.AppointmentService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AppointmentTest {

    private AppointmentDao appointmentDao;
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        appointmentDao = Mockito.mock(AppointmentDao.class);
    }

    @Test
    public void testShowTotalPriceOfAppointments() {     

        when(appointmentDao.getTotalPriceOfAppointments()).thenReturn(80000.0);

        double totalPrice = appointmentService.getTotalPriceOfAppointments();

        assertEquals(80000.0, totalPrice, 0.01);

    }
}
