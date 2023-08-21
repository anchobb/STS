package com.test.app.Domain.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.xerces.util.URI;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.test.app.Domain.Dao.MusicSearchHistoryDao;
import com.test.app.Domain.Dao.MusicSearchHistoryDaoImpl;
import com.test.app.Domain.Dto.MemberDto;
import com.test.app.Domain.Dto.MusicDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MusicService {

	private DefaultTableModel model;
	
	// ΩÃ±€≈Ê
	private static MusicService instance;

	public static MusicService getInstance() {
		if (instance == null)
			instance = new MusicService();
		return instance;
	}

	public DefaultTableModel getTableModel() {
		return model;
	}

	public MusicService(DefaultTableModel model) {
		this.model = model;
	}

	public MusicService() {

	}

		public List<MusicDto> searchTracks(String searchText, String memberId) throws Exception {
			List<MusicDto> list = new ArrayList();
			MemberDto dto = new MemberDto();
			dto.setId(memberId);
			try {
		
				String apiKey = "354ad741231e3c7ae853e84460461072";
				String encodedTrack = searchText;
				String apiUrl = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" + encodedTrack
						+ "&limit=300&api_key=" + apiKey + "&format=json";
				HttpClient httpClient = HttpClient.newHttpClient();
				HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
	
				HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
				String responseBody = response.body();
	
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode root = objectMapper.readTree(responseBody);
				JsonNode trackMatches = root.path("results").path("trackmatches").path("track");
	
				for (JsonNode trackNode : trackMatches) {
					String name = trackNode.path("name").asText();
					String artist = trackNode.path("artist").asText();
					String url = trackNode.path("url").asText();
					list.add(new MusicDto(name, artist, url));					
				}
				
//				if (memberId != null && !memberId.isEmpty()) {
//		            dao.insert(dto, searchText);
//		        }
	
				
				
			} catch (IOException | InterruptedException ex) {
				ex.printStackTrace();
			}
			// ∏Æ≈œ«œ±‚
	
			return list;
		}

	public List<MusicDto> openWebpage(String url) {
		List<MusicDto> list = new ArrayList();
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(new URI(url));
			}
		} catch (IOException | URISyntaxException ex) {
			ex.printStackTrace();
		}
		list.add(new MusicDto(url));
		return list;
	}
	

}