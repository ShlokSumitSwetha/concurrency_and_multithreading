package Complete_Concurrent_Collections.structure_concurrency;

import java.util.*;
import java.util.concurrent.*;

public class main {
	public static void main(String[] args) {

		try{
			List<String> codes= List.of("NO", "AUS", "IND" );
			var executorService = Executors.newFixedThreadPool(10);
			var futures = new ArrayList<Future<String>>();
			for(var code: codes){
				futures.add(executorService.submit(()->getNameOfAirport(code)));
			}
			for(var future: futures){
				try {
					System.out.println(future.get());
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
			executorService.shutdown();
			executorService.awaitTermination(10, TimeUnit.SECONDS);
		}
		catch (Exception e){
           System.out.println(e);
		}
	}





	public static String getNameOfAirport(String data){

		var mockData = Map.of(
				"AUS", "Australia",
				"IND", "INDIA"
		);

		var name = mockData.get(data);

		if(name == null){
			throw new RuntimeException("Invalid airport:"+ data);
		}
		return name;
	}
}
