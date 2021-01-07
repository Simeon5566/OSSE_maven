package de.hfu.praktikum;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;




import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;


public class ResidentRepositoryStub implements ResidentRepository
{
	@Override
	public List<Resident> getResidents() {
		List<Resident> stub = new ArrayList<Resident>();
		try {
			Date simeon = new Date(1998,3,1);
			Resident Simeon = new Resident("Simeon", "Messerschmidt", "Baumannstraße 31", "Furtwangen", simeon);
			stub.add(Simeon);
			
			Date moritz = new Date(1990,12,18);
			Resident Moritz = new Resident("Moritz", "Messerschmidt", "Steinhofweg 4", "Heidelberg", moritz);
			stub.add(Moritz);
			
			Date irina = new Date(1988, 2, 25);
			Resident Irina = new Resident("Irina", "Scharschmidt", "Wilhelmstraße 11", "Muenchen", irina);
			stub.add(Irina);
			
			Date luca = new Date(2001, 8, 15);
			Resident Luca = new Resident("Luca", "Brodbeck", "Auguststraße 22", "Karlsruhe", luca);
			stub.add(Luca);
			
			Date marc = new Date(2001, 8, 15);
			Resident Marc = new Resident("Marc", "Messerschmidt", "Steinstraße 1", "Heilbronn", moritz);
			stub.add(Marc);
		} catch(Exception a) {
		}
		// TODO Auto-generated method stub
		return stub;
	}
}
