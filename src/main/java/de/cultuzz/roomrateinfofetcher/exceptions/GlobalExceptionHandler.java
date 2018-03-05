package de.cultuzz.roomrateinfofetcher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cultagent.mappings.CultuzzCommRS;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RoomRateFetcherInfoException.class)
	public final ResponseEntity<CultuzzCommRS> handleRoomRateFetcherInfoException(RoomRateFetcherInfoException roomRateFetcherInfoException){
		CultuzzCommRS cultuzzCommRS = new CultuzzCommRS();
		cultuzzCommRS.setStatus(roomRateFetcherInfoException.getErrorMsg());
		return new ResponseEntity<>(cultuzzCommRS, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CultuzzCommRS> handleAllExceptions(Exception ex) {
		CultuzzCommRS cultuzzCommRS = new CultuzzCommRS();
		cultuzzCommRS.setStatus(ex.getMessage());
		return new ResponseEntity<>(cultuzzCommRS, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
