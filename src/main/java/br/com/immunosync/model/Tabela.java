package br.com.immunosync.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Tabela {
//	@JsonProperty("cd_tabela")
//    @SerializedName("cd_tabela")
	private int id;
//	@JsonProperty("ds_bcg")
//    @SerializedName("ds_bcg")
	private String bcg;
//	@JsonProperty("ds_hepatiteB")
//    @SerializedName("ds_hepatiteB")
	private String hepatiteB;
//	@JsonProperty("ds_rotavirus")
//    @SerializedName("ds_rotavirus")
	private String rotavirus;
//	@JsonProperty("ds_dtpa")
//    @SerializedName("ds_dtpa")
	private String dtpa;
//	@JsonProperty("ds_vip")
//    @SerializedName("ds_vip")
	private String vip;
//	@JsonProperty("ds_hib")
//    @SerializedName("ds_hib")
	private String hib;
//	@JsonProperty("ds_vpc10")
//    @SerializedName("ds_vpc10")
	private String vpc10;
//	@JsonProperty("ds_meningococicasConjugadas")
//    @SerializedName("ds_meningococicasConjugadas")
	private String meningococicasConjugadas;
//	@JsonProperty("ds_meningococicaB")
//    @SerializedName("ds_meningococicaB")
	private String meningococicaB;
//	@JsonProperty("ds_influenza")
//    @SerializedName("ds_influenza")
	private String influenza;
//	@JsonProperty("ds_febreAmarela")
//    @SerializedName("ds_febreAmarela")
	private String febreAmarela;
//	@JsonProperty("ds_scr")
//    @SerializedName("ds_scr")
	private String scr;
//	@JsonProperty("ds_varicela")
//    @SerializedName("ds_varicela")
	private String varicela;
//	@JsonProperty("ds_hepatiteA")
//    @SerializedName("ds_hepatiteA")
	private String hepatiteA;
//	@JsonProperty("ds_hpv4")
//    @SerializedName("ds_hpv4")
	private String hpv4;
//	@JsonProperty("ds_dengue")
//    @SerializedName("ds_dengue")
	private String dengue;
//	@JsonProperty("ds_covid19")
//    @SerializedName("ds_covid19")
	private String covid19;
//	@JsonProperty("cd_paciente")
//	@SerializedName("cd_paciente")
	private int idPaciente;
	
	public Tabela() {
		
	}

	public Tabela(int id, String bcg, String hepatiteB, String rotavirus, String dtpa, String vip, String hib,
			String vpc10, String meningococicasConjugadas, String meningococicaB, String influenza, String febreAmarela,
			String scr, String varicela, String hepatiteA, String hpv4, String dengue, String covid19, int idPaciente) {
		super();
		this.id = id;
		this.bcg = bcg;
		this.hepatiteB = hepatiteB;
		this.rotavirus = rotavirus;
		this.dtpa = dtpa;
		this.vip = vip;
		this.hib = hib;
		this.vpc10 = vpc10;
		this.meningococicasConjugadas = meningococicasConjugadas;
		this.meningococicaB = meningococicaB;
		this.influenza = influenza;
		this.febreAmarela = febreAmarela;
		this.scr = scr;
		this.varicela = varicela;
		this.hepatiteA = hepatiteA;
		this.hpv4 = hpv4;
		this.dengue = dengue;
		this.covid19 = covid19;
		this.idPaciente = idPaciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBcg() {
		return bcg;
	}

	public void setBcg(String bcg) {
		this.bcg = bcg;
	}

	public String getHepatiteB() {
		return hepatiteB;
	}

	public void setHepatiteB(String hepatiteB) {
		this.hepatiteB = hepatiteB;
	}

	public String getRotavirus() {
		return rotavirus;
	}

	public void setRotavirus(String rotavírus) {
		this.rotavirus = rotavírus;
	}

	public String getDtpa() {
		return dtpa;
	}

	public void setDtpa(String dtpa) {
		this.dtpa = dtpa;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getHib() {
		return hib;
	}

	public void setHib(String hib) {
		this.hib = hib;
	}

	public String getVpc10() {
		return vpc10;
	}

	public void setVpc10(String vpc10) {
		this.vpc10 = vpc10;
	}

	public String getMeningococicasConjugadas() {
		return meningococicasConjugadas;
	}

	public void setMeningococicasConjugadas(String meningococicasConjugadas) {
		this.meningococicasConjugadas = meningococicasConjugadas;
	}

	public String getMeningococicaB() {
		return meningococicaB;
	}

	public void setMeningococicaB(String meningococicaB) {
		this.meningococicaB = meningococicaB;
	}

	public String getInfluenza() {
		return influenza;
	}

	public void setInfluenza(String influenza) {
		this.influenza = influenza;
	}

	public String getFebreAmarela() {
		return febreAmarela;
	}

	public void setFebreAmarela(String febreAmarela) {
		this.febreAmarela = febreAmarela;
	}

	public String getScr() {
		return scr;
	}

	public void setScr(String scr) {
		this.scr = scr;
	}

	public String getVaricela() {
		return varicela;
	}

	public void setVaricela(String varicela) {
		this.varicela = varicela;
	}

	public String getHepatiteA() {
		return hepatiteA;
	}

	public void setHepatiteA(String hepatiteA) {
		this.hepatiteA = hepatiteA;
	}

	public String getHpv4() {
		return hpv4;
	}

	public void setHpv4(String hpv4) {
		this.hpv4 = hpv4;
	}

	public String getDengue() {
		return dengue;
	}

	public void setDengue(String dengue) {
		this.dengue = dengue;
	}

	public String getCovid19() {
		return covid19;
	}

	public void setCovid19(String covid19) {
		this.covid19 = covid19;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "Tabela [id=" + id + ", bcg=" + bcg + ", hepatiteB=" + hepatiteB + ", rotavírus=" + rotavirus + ", dtpa="
				+ dtpa + ", vip=" + vip + ", hib=" + hib + ", vpc10=" + vpc10 + ", meningocócicasConjugadas="
				+ meningococicasConjugadas + ", meningocócicaB=" + meningococicaB + ", influenza=" + influenza
				+ ", febreAmarela=" + febreAmarela + ", scr=" + scr + ", varicela=" + varicela + ", hepatiteA="
				+ hepatiteA + ", hpv4=" + hpv4 + ", dengue=" + dengue + ", covid19=" + covid19
				+ ", idPaciente=" + idPaciente + "]";
	}
}
