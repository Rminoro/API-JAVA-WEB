package br.com.immunosync.crud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.immunosync.model.Tabela;

public class TabelaCrud {

public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		ArrayList<Tabela> listaTabelas = new ArrayList<Tabela>();
		
		carregarDadosDoArquivo(listaTabelas);
		
		int contador = 0;
		int id = obterUltimoId(listaTabelas);
		
		while(contador != 5) {
			System.out.println("-----SISTMA DE TABELA DE VACINAS-----");
			System.out.println("1 - Cadastro de Tabela");
			System.out.println("2 - Listagem de Tabela");
			System.out.println("3 - Atualizar Tabela");
			System.out.println("4 - Deletar Tabela");
			System.out.println("5 - Sair");
			contador = leitor.nextInt();
			leitor.nextLine();
			
			if(contador == 1) {
				System.out.println("---Informe os dados do Paciente---");
				id++;
				
				System.out.println("Vacina BCG ?/1:");
		        String bcg = leitor.next();

		        if (validarVacina(bcg)) {
		            System.out.println("Vacina Hepatite B ?/4:");
		            String hepatiteB = leitor.next();

		            if (validarVacina(hepatiteB)) {
		                System.out.println("Vacina Rotavírus ?/3:");
		                String rotavirus = leitor.next();

		                if (validarVacina(rotavirus)) {
		                    System.out.println("Vacina DTPa ?/6:");
		                    String dtpa = leitor.next();

		                    if (validarVacina(dtpa)) {
		                        System.out.println("Vacina VIP ?/5:");
		                        String vip = leitor.next();

		                        if (validarVacina(vip)) {
		                            System.out.println("Vacina Hib ?/4:");
		                            String hib = leitor.next();

		                            if (validarVacina(hib)) {
		                                System.out.println("Vacina VPC10 ?/4:");
		                                String vpc10 = leitor.next();

		                                if (validarVacina(vpc10)) {
		                                    System.out.println("Vacina Meningocócicas Conjugadas ?/6:");
		                                    String meningococicasConjugadas = leitor.next();

		                                    if (validarVacina(meningococicasConjugadas)) {
		                                        System.out.println("Vacina Meningocócica B ?/3:");
		                                        String meningococicaB = leitor.next();

		                                        if (validarVacina(meningococicaB)) {
		                                            System.out.println("Vacina Influenza ?/2:");
		                                            String influenza = leitor.next();

		                                            if (validarVacina(influenza)) {
		                                                System.out.println("Vacina Febre Amarela ?/2:");
		                                                String febreAmarela = leitor.next();

		                                                if (validarVacina(febreAmarela)) {
		                                                    System.out.println("Vacina SCR ?/2:");
		                                                    String scr = leitor.next();

		                                                    if (validarVacina(scr)) {
		                                                        System.out.println("Vacina Varicela ?/2:");
		                                                        String varicela = leitor.next();

		                                                        if (validarVacina(varicela)) {
		                                                            System.out.println("Vacina Hepatite A ?/2:");
		                                                            String hepatiteA = leitor.next();

		                                                            if (validarVacina(hepatiteA)) {
		                                                                System.out.println("Vacina HPV4: ?/5");
		                                                                String hpv4 = leitor.next();

		                                                                if (validarVacina(hpv4)) {
		                                                                    System.out.println("Vacina Dengue ?/3:");
		                                                                    String dengue = leitor.next();

		                                                                    if (validarVacina(dengue)) {		                                                                      
		                                                                        System.out.println("Vacina COVID-19:");
		                                                                        String covid19 = leitor.next();

		                                                                        if (validarVacina(covid19)) {
		                                                                            System.out.println("ID do paciente:");
		                                                                            int idPaciente = leitor.nextInt();
		                                                                            
		                                                                            Tabela novaTabela = new Tabela(id, bcg, hepatiteB, rotavirus, dtpa, vip, hib, vpc10,
		                                                                                    meningococicasConjugadas, meningococicaB, influenza, febreAmarela, scr, varicela,
		                                                                                    hepatiteA, hpv4, dengue, covid19, idPaciente);
		                                                                            listaTabelas.add(novaTabela);
		                                                                        }
		                                                                    }
		                                                                }
		                                                            }
		                                                        }
		                                                    }
		                                                }
		                                            }
		                                        }
		                                    }
		                                }
		                            }
		                        }
		                    }
		                }
		            }
		        }
			}else if(contador == 2) {
				int opcaoListagem = 0;
				System.out.println("1 - Listagem geral de Tabelas");
				System.out.println("2 - Listagem por id de Tabela");
				opcaoListagem = leitor.nextInt();
				leitor.nextLine();
				
				if(opcaoListagem == 1) {
					listarTodasTabelas(listaTabelas);
				}else if(opcaoListagem == 2) {
					System.out.println("---Informe o id da Tabela---");
					int idTabela = leitor.nextInt();
					leitor.nextLine();
					listarTabelaPorId(listaTabelas, idTabela);
				}
				
			} else if(contador == 3) {
				System.out.println("---Atualizar Tabela---");
			    System.out.println("Informe o ID da Tabela que deseja atualizar:");
			    int idTabelaAtualizar = leitor.nextInt();
			    leitor.nextLine(); 

			    Tabela tabelaParaAtualizar = encontrarTabelaPorId(listaTabelas, idTabelaAtualizar);

			    if (tabelaParaAtualizar != null) {
			        System.out.println("---Informe os novos dados da Tabela---");

					System.out.println("Vacina BCG ?/1:");
			        String novaBCG = leitor.next();
			        if (validarVacina(novaBCG)) {
			            tabelaParaAtualizar.setBcg(novaBCG);
			        } else {
			            System.out.println("A vacina BCG deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Hepatite B ?/4:");
			        String novaHepatiteB = leitor.next();
			        if (validarVacina(novaHepatiteB)) {
			            tabelaParaAtualizar.setHepatiteB(novaHepatiteB);
			        } else {
			            System.out.println("A vacina Hepatite B deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Rotavírus ?/3:");
			        String novaRotavirus = leitor.next();
			        if (validarVacina(novaRotavirus)) {
			            tabelaParaAtualizar.setRotavirus(novaRotavirus);
			        } else {
			            System.out.println("A vacina Rotavírus deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina DTPa ?/6:");
			        String novaDtpa = leitor.next();
			        if (validarVacina(novaDtpa)) {
			            tabelaParaAtualizar.setDtpa(novaDtpa);
			        } else {
			            System.out.println("A vacina DTPa deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina VIP ?/5:");
			        String novaVip = leitor.next();
			        if (validarVacina(novaVip)) {
			            tabelaParaAtualizar.setVip(novaVip);
			        } else {
			            System.out.println("A vacina VIP deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Hib ?/4:");
			        String novaHib = leitor.next();
			        if (validarVacina(novaHib)) {
			            tabelaParaAtualizar.setHib(novaHib);
			        } else {
			            System.out.println("A vacina Hib deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina VPC10 ?/4:");
			        String novaVpc10 = leitor.next();
			        if (validarVacina(novaVpc10)) {
			            tabelaParaAtualizar.setVpc10(novaVpc10);
			        } else {
			            System.out.println("A vacina VPC10 deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Meningocócicas Conjugadas ?/6:");
			        String novaMeningococicasConjugadas = leitor.next();
			        if (validarVacina(novaMeningococicasConjugadas)) {
			            tabelaParaAtualizar.setMeningococicasConjugadas(novaMeningococicasConjugadas);
			        } else {
			            System.out.println("A vacina Meningocócicas Conjugadas deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Meningocócica B ?/3:");
			        String novaMeningococicaB = leitor.next();
			        if (validarVacina(novaMeningococicaB)) {
			            tabelaParaAtualizar.setMeningococicaB(novaMeningococicaB);
			        } else {
			            System.out.println("A vacina Meningocócica B deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Influenza ?/2:");
			        String novaInfluenza = leitor.next();
			        if (validarVacina(novaInfluenza)) {
			            tabelaParaAtualizar.setInfluenza(novaInfluenza);
			        } else {
			            System.out.println("A vacina Influenza deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Febre Amarela ?/2:");
			        String novaFebreAmarela = leitor.next();
			        if (validarVacina(novaFebreAmarela)) {
			            tabelaParaAtualizar.setFebreAmarela(novaFebreAmarela);
			        } else {
			            System.out.println("A vacina Febre Amarela deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina SCR ?/2:");
			        String novaScr = leitor.next();
			        if (validarVacina(novaScr)) {
			            tabelaParaAtualizar.setScr(novaScr);
			        } else {
			            System.out.println("A vacina SCR deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Varicela ?/2:");
			        String novaVaricela = leitor.next();
			        if (validarVacina(novaVaricela)) {
			            tabelaParaAtualizar.setVaricela(novaVaricela);
			        } else {
			            System.out.println("A vacina Varicela deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Hepatite A ?/2:");
			        String novaHepatiteA = leitor.next();
			        if (validarVacina(novaHepatiteA)) {
			            tabelaParaAtualizar.setHepatiteA(novaHepatiteA);
			        } else {
			            System.out.println("A vacina Hepatite A deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina HPV4: ?/5");
			        String novaHpv4 = leitor.next();
			        if (validarVacina(novaHpv4)) {
			            tabelaParaAtualizar.setHpv4(novaHpv4);
			        } else {
			            System.out.println("A vacina HPV4 deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina Dengue ?/3:");
			        String novaDengue = leitor.next();
			        if (validarVacina(novaDengue)) {
			            tabelaParaAtualizar.setDengue(novaDengue);
			        } else {
			            System.out.println("A vacina Dengue deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }

			        System.out.println("Vacina COVID-19:");
			        String novaCovid19 = leitor.next();
			        if (validarVacina(novaCovid19)) {
			            tabelaParaAtualizar.setCovid19(novaCovid19);
			        } else {
			            System.out.println("A vacina COVID-19 deve ter no máximo 50 caracteres. Tabela não atualizada");
			            return;
			        }
			        
			        System.out.println("ID do paciente:");
			        int novoIdPaciente = leitor.nextInt();
			        tabelaParaAtualizar.setIdPaciente(novoIdPaciente);

		             
		             System.out.println("Tabela atualizada com sucesso!");
		             
			    } else {
			        System.out.println("Tabela com o ID " + idTabelaAtualizar + " não encontrado");
			    }
			}else if(contador == 4) {
				System.out.println("---Deletar Tabela---");
			    System.out.println("Informe o ID da Tabela que deseja deletar:");
			    int idTabelaDeletar = leitor.nextInt();
			    leitor.nextLine();

			    Tabela tabelaParaDeletar = encontrarTabelaPorId(listaTabelas, idTabelaDeletar);

			    if (tabelaParaDeletar != null) {
			    	listaTabelas.remove(tabelaParaDeletar);
			        System.out.println("---Tabela deletada com sucesso---");
			    } else {
			        System.out.println("Tabela com o ID " + idTabelaDeletar + " não encontrado");
			    }
			}if(contador == 5) {
				salvarDadosNoArquivo(listaTabelas);
			}
		}
	}
		
		private static void salvarDadosNoArquivo(ArrayList<Tabela> listaTabelas) {
		    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tabelas.txt"))) {
		        Gson gson = new Gson();
		        for (Tabela tabela : listaTabelas) {
		            String json = gson.toJson(tabela);
		            bufferedWriter.write(json);
		            bufferedWriter.newLine();
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		private static void carregarDadosDoArquivo(ArrayList<Tabela> listaTabelas) {
		    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("tabelas.txt"))) {
		        String linha;
		        Gson gson = new Gson();
		        while ((linha = bufferedReader.readLine()) != null) {
		        	Tabela tabela = gson.fromJson(linha, Tabela.class);
		            if (tabela != null) {
		            	listaTabelas.add(tabela);
		            }
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		        System.out.println("Erro ao carregar dados no arquivo: " + e.getMessage());
		    }
		}
		
		private static int obterUltimoId(ArrayList<Tabela> listaTabelas) {
	    	int ultimoId = 0;
	    	for(Tabela tabela : listaTabelas) {
	    		if(tabela.getId() > ultimoId) {
	    			ultimoId = tabela.getId();
	    		}
	    	}
	        return ultimoId;
		}
		
		private static Tabela encontrarTabelaPorId(ArrayList<Tabela> listaTabelas, int id) {
		    for (Tabela tabela : listaTabelas) {
		        if (tabela.getId() == id) {
		            return tabela;
		        }
		    }
		    return null;
		}
		
		private static void listarTodasTabelas(ArrayList<Tabela> listaTabelas) {
	        System.out.println("---Lista de Tabelas---");
	        for (Tabela tabela : listaTabelas) {
	            System.out.println(tabela);
	        }
	    }
		
		private static void listarTabelaPorId(ArrayList<Tabela> listaTabelas, int id) {
			System.out.println("---Listagem de Tabela por id---");
			for(Tabela tabela : listaTabelas) {
				if(tabela.getId() == id) {
					System.out.println(tabela);
					return;
				}
			}
			
			System.out.println("Tabela com o ID " + id + " não encontrado");
		}
		
		private static boolean validarVacina(String vacina) {
		    if (vacina.length() <= 50) {
		        return true;
		    } else {
		        System.out.println("Erro: O nome da Vacina deve ter no máximo 50 caracteres.");
		        return false;
		    }
		}
}
