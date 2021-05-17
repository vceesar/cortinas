const search = document.getElementById('search');
const matchList = document.getElementById("match-list");


const searchItem = async searchText => {
    const res = await fetch("/JsonItens/Filme.json");
    const itens  = await res.json();

    let matches = itens.filter(item => {
        const regex = new RegExp(`^${searchText}`, 'gi');
        return item.tituloFilme.match(regex);
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
        <div class= "searchbarfunc mb-1">
            <h4> ${match.tituloFilme} (${match.anoFilme})<span class = "text-danger"> ${match.paisFilme} </span> </h4>
        </div>
        `
        )
        .join('');


    matchList.innerHTML = html;
    }
}

search.addEventListener('input', () => searchItem(search.value));