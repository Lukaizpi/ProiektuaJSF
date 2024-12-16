package eredua.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;

@ManagedBean(name = "rideBean")
@RequestScoped
public class RideBean implements Serializable {
	private String from;
	private String to;
	private Date date;
	private int nPlaces;
	private float price;
	private String driverEmail;
	private BLFacade facadeBL;
	private static final long serialVersionUID = 1L;

	public RideBean() {
		this.facadeBL = FacadeBean.getBusinessLogic();
	}

	// Getters y setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getnPlaces() {
		return nPlaces;
	}

	public void setnPlaces(int nPlaces) {
		this.nPlaces = nPlaces;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDriverEmail() {
		return driverEmail;
	}

	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}

	public String createRide() {
		try {
		
			facadeBL.createRide(from, to, date, nPlaces, price, driverEmail);
			 FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage("Ride created"));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public String close() {
		return "ok3";
	}

}
