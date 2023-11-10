package com.example.demo.core.utilities.mappers;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModelMapperManager implements ModelMapperService {
	private ModelMapper modelMapper;
	@Autowired
	public ModelMapperManager(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	public ModelMapperManager() {
		
	}
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)  // Ambiguity = Belirsizlik. Mapping objesinde aynı isimlerdeki verilerin belirsizlik yaratması konusunda hata vermesini engellemek için Ignored i true yapıyoruz.
		.setMatchingStrategy(MatchingStrategies.LOOSE); // Veritabanı nesnesindeki bütün columnları almamıza gerek olmadığını belirtiyoruz.
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE); // Requestte ise bütün verilerin doğru girilip, veri tabanıyla eşlenmesini kontrol etmek istediğimiz için standart yaptık.
		return this.modelMapper;
	}
	
}
