public class Nutricao{
    private int gramasRacao;
    private int gramasVerdura;
    private int gramasFeno;
    public void CalcularquantidadeDeComida(int idade,int Peso){
       if(idade<=15){
           Porquinho();
       }else{
            Porquinho(Peso);
       }
    }

    private void Porquinho(){
        setGramasRacao(40);
        setGramasVerdura(300);
        setGramaFeno(840);
    }

    private void Porquinho(int Peso){
        if(Peso>500){
            setGramasRacao(45);
            setGramasVerdura(225);
            setGramaFeno(630);
        }else{
            setGramasRacao(60);
            setGramasVerdura(300);
            setGramaFeno(840);
        }
    }

    private void setGramasRacao(int gramasRacao){
        this.gramasRacao=gramasRacao;
    }

    private void setGramasVerdura(int gramasVerdura){
        this.gramasVerdura=gramasVerdura;
    }
    private void setGramaFeno(int gramasFeno){
        this.gramasFeno=gramasFeno;
    }

    public int getGramasRacao(){
        return this.gramasRacao;
    }

    public int getGramasVerdura(){
        return this.gramasVerdura;
    }

    public int getGramasFeno(){
        return this.gramasFeno;
    }

/*
<=15 meses --- jovem
racao: 20 gramas *2
verdura: 300 gramas

>15 meses --- adulto


funcao relacionada ao peso de 500 gramas
70% feno    --- 630 gramas   
25% verdura --- 225 gramas
5% racao    --- 45 gramas

>500
70% feno    --- 840 gramas
25% verdura --- 300 gramas
5% racao    --- 60 gramas

https://www.peritoanimal.com.br/quantidade-diaria-de-comida-para-porquinho-da-india-21881.html
*/
}