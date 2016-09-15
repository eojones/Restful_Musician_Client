package br.com.fiap.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.fiap.entity.Musician;

public class MusicianRepository {
	private URL url;
	private HttpURLConnection conn;
	private String ws = "http://localhost:8081/Restful_Musician/rest/musician/";

	public void function(Musician m, String method, String path, String operacao) {
		try {
			ws = (path == null || path.length() < 1) ? ws : ws + path;
			url = new URL(ws);
			conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod(method);
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("content-type", "application/json");
			conn.setDoOutput(true);

			if (method != "DELETE") {
				OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
				writer.write(new Gson().toJson(m));
				writer.close();
			}
			int statusCode = conn.getResponseCode();
			if (statusCode != 201 && statusCode != 200) {
				throw new Exception("Erro\n Operação: " + operacao);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void register(Musician m) {
		function(m, "POST", null, "CADASTRAR");
	}

	public void alter(Musician m) {
		function(m, "PUT", null, "ALTERAR");
	}

	public void delete(Musician m) {
		function(m, "DELETE", String.valueOf(m.getId()), "DELETAR");
	}

	public List<Musician> list() throws Exception {
		try {
			url = new URL(ws);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("charset", "utf-8");

			int statucCode = conn.getResponseCode();
			if (statucCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder b = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					b.append(line);
				}
				Musician[] mArray = new Gson().fromJson(b.toString(), Musician[].class);
				return Arrays.asList(mArray);
			}
		} catch (Exception e) {
		}
		throw new Exception("Erro ao listar");
	}

}
