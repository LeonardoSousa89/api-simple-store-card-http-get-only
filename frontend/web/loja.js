async function requisicao() {
    const url = 'http://localhost:8080/card'
    const config = {
        method:'GET',
        status:200,
        cache:'default',
        mode:'cors'
    }
 await fetch(url,config).then(response => response.json())
              .then(response => {
                 response.map(cardProd =>{
                      let main = document.querySelector('main')
                       
                      let tituloBkd    = cardProd.titulo
                      let descricaoBkd = cardProd.descricao
                      let precoBkd     = cardProd.preco

                      let tituloObj = document.createElement('h4')
                      let descricaoObj = document.createElement('h5')
                      let precoObj = document.createElement('p')

                      tituloObj.append(tituloBkd)
                      descricaoObj.append(descricaoBkd)
                      precoObj.append(precoBkd)
                      
                      let cardItem = document.createElement('div')
                      cardItem.append(tituloObj,descricaoObj,precoObj) 
                     
                      main.append(cardItem)

                            /** avaliação de erro de retorno UNDEFINED */

                                //aqui os dados são pegos em sua totalidade!
                                //console.log(tituloBkd + ',' + descricaoBkd + ',' + precoBkd)

                                //aqui os dados são tratados porém continuam com sua integridade!
                                //console.log(tituloObj,descricaoObj,precoObj)

                                //aqui os dados já se corrompem
                                //console.log(titulo,descricao,preco)

                       /** avaliação de erro de retorno UNDEFINED */
                  })
              })
              .catch(err =>{
                let main = document.querySelector('main')

                let msg  = 'Erro ao acessar o servidor!'
                let msgContainer = document.createElement('h3')
                msgContainer.append(msg)
                
                let cardItem = document.createElement('div')
                cardItem.append(msgContainer)

                cardItem.style.textAlign = 'center'
                cardItem.style.fontSize = '35px'
                cardItem.style.background = 'darkred'
                cardItem.style.color = 'whitesmoke'
                cardItem.style.width = '90%'

                main.append(cardItem)
                console.log('Erro:' + err)
              })        
}


requisicao()