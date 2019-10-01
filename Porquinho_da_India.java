public class Porquinho_da_India{
        private String Nome;
        private int Peso;//<---- GRAMAS!!!!!
        private int Idade;//em meses

        //quantidade de alimento em gramas
        private int quantidadeRacao;
        private int quantidadeFeno;
        private int quantidadeVerdura;

        Porquinho_da_India(String nome,int Peso,int idade){
            setNome(nome);
            setPeso(Peso);
            setIdade(idade);
        }
        
        public void setNome(String nome){
            this.Nome=nome;
        }
        public void setPeso(int peso){
            this.Peso=peso;
        }
        public void setIdade(int idade){
            this.Idade=idade;
        }
        public void setQuantidadeDeRacao(int Racaoquantidade){
            this.quantidadeRacao=Racaoquantidade;
        }

        public String getNome(){
            return this.Nome;
        }
        public int getPeso(){
            return this.Peso;
        }
        public int getIdade(){
            return this.Idade;
        }
        

        public void setQuantidadeRacao(int gramasRacao){
            this.quantidadeRacao=gramasRacao;
        }
    
        public void setQuantidadeVerdura(int gramasVerdura){
            this.quantidadeVerdura=gramasVerdura;
        }
        public void setQuantidadeFeno(int gramasFeno){
            this.quantidadeFeno=gramasFeno;
        }
    
        public int getQuantidadeRacao(){
            return this.quantidadeRacao;
        }
    
        public int getQuantidadeVerdura(){
            return this.quantidadeVerdura;
        }
    
        public int getQuantidadeFeno(){
            return this.quantidadeFeno;
        }

}