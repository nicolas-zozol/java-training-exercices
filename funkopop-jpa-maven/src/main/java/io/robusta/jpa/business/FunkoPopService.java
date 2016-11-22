package io.robusta.jpa.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.robusta.jpa.entities.FunkoPop;


public class FunkoPopService 
{

	EntityManager em;


	public List<FunkoPop> findAll()
	{
		// This is not SQL, it is JPQL :
		// Java Persistence Query Language
		return em.createQuery("SELECT f FROM FunkoPop f", FunkoPop.class).getResultList();
	}

	public void delete( int id )
	{
		FunkoPop pop = findFunkoPopById( id );
		if( pop != null )
			em.remove( pop );
	}

	
	public FunkoPop createOrUpdate( FunkoPop pop )
	{
		FunkoPop existing = findFunkoPopById( pop.getId() );
		if( existing != null )
		{
			// update
			existing.setName( pop.getName() );
			existing.setUniverse( pop.getUniverse() );
			existing.setWaterproof( pop.isWaterproof() );
			existing.setLongitude( pop.getLongitude() );
			existing.setLatitude( pop.getLatitude() );

			return existing;
		}
		else
		{	
			pop.setId(0);
			em.persist( pop );
			return pop;
		}
	}

	public List<FunkoPop> search( String name, String universe )
	{
		List<FunkoPop> result = new ArrayList<>();

		return result;
	}


    ExternalService externalService;
	/**
	 * If it's rainy, funkoPops have to move to Shelter
	 * @return
	 */
	public List<FunkoPop> getFunkoPopsToShelter()
	{
		
		// Always difficult to choose between Optional and Exception !
		boolean weatherGood = externalService.isWeatherGood()
				.orElseThrow(() -> new RuntimeException("No weather found"));

		List<FunkoPop> result = new ArrayList<>();

		if( !weatherGood )
		{
			for( FunkoPop pop : this.findAll() )
			{
				if( !pop.isWaterproof() )
					result.add( pop );
			}
		}

		System.out.println(weatherGood + ": "+result);
		return result;
	}

	public Optional<Integer> getTravelTime( int fromFunkoPopId, int toFunkoPopId )
	{
		FunkoPop from = findFunkoPopById( fromFunkoPopId );
		FunkoPop to = findFunkoPopById( toFunkoPopId );
		
		if( from == null || to == null)
			return Optional.empty();
		
		return new ExternalService().getTravelTime(
				from.getLatitude(), from.getLongitude(),
				to.getLatitude(), to.getLongitude());
		//return (int) result.routes[0].legs[0].duration.value;
	}

	public FunkoPop findFunkoPopById( int funkoPopId )
	{
		return em.find(FunkoPop.class, funkoPopId);
	}

	private boolean isValid( String value, String criteria )
	{
		return criteria == null || (value != null && value.contains( criteria ));
	}
}
