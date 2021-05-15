const search = document.getElementById('search');
const matchList = document.getElementById("match-list");


const searchItem = async searchText => {
    const res = await fetch("/JsonItens/Livro.json");
    const itens  = await res.json();

    let matches = itens.filter(item => {
        const regex = new RegExp(`^${searchText}`, 'gi');
        return item.tituloLivro.match(regex);
    });

    if(searchText.length == 0){
        matches = [];
        matchList.innerHTML = '';
    }

    outputHtml(matches);
    console.log(matches);

};

const outputHtml = matches => {
    if(matches.length > 0){
        const html = matches.map(match => `
        <div class= "searchbarfunc2 mb-1">
            <h4> ${match.tituloLivro} (${match.editora})<span class = "text-danger"> ${match.autorLivro} </span> </h4>
        </div>
        `
        )
            .join('');


        matchList.innerHTML = html;
    }
}

search.addEventListener('input', () => searchItem(search.value));