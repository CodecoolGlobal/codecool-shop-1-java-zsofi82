const categoryList = document.querySelectorAll('.category-list');
const container = document.querySelector('#container');
const addButton = document.querySelectorAll('#addButton');

function addToCart(clickEvent){
    const heroId = clickEvent.currentTarget.dataset.eventId;
    const productId = document.querySelector(`select[data-event-id="${heroId}"]`);

    apiPut('/api/order', productId.dataset.eventId, 1, heroId);
}

function apiPut(url, productId, quantity, heroId){
    fetch(url, {
        method: "PUT",
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(
            {
                productID: productId,
                quantity: quantity,
                heroId: heroId
            }
        )
    })
}

async function apiGet(url) {
    let response = await fetch(url);
    if (response.ok) {
        return response.json();
    }
}

async function createTBody(url) {
    let data = await apiGet(url);

    data.orderitems.forEach(element => {
        const tr = document.createElement('tr');
        const heroNameTd = document.createElement('td');
        const productNameTd = document.createElement('td');
        const quantityTd = document.createElement('td');
        const plusBtn = document.createElement("button");
        const minusBtn = document.createElement("button");
        let counterSpan = document.createElement("span");

        const heroName = data.heroes[element.heroId].name;
        const productName = data.productcategories[element.productId].name;
        const quantity = element.quantity;

        plusBtn.dataset.superheroId = element.heroId;
        minusBtn.dataset.superheroId = element.heroId;
        counterSpan.dataset.superheroId = element.heroId;
        plusBtn.classList.add('btn', 'btn-primary');
        minusBtn.classList.add('btn', 'btn-primary');

        heroNameTd.innerText = heroName;
        productNameTd.innerText = productName;
        quantityTd.innerText = quantity;
        plusBtn.innerText = "+";
        minusBtn.innerText = "-";
        counterSpan.innerText = "0";

        plusBtn.addEventListener('click', increase);
        minusBtn.addEventListener('click', decrease);

        quantityTd.append(plusBtn, counterSpan, minusBtn);
        tr.append(heroNameTd, productNameTd, quantityTd);
        container.appendChild(tr);
    });
}

function increase(clickEvent){
    let counter = parseInt(clickEvent.currentTarget.nextSibling.innerText);
    counter += 1;
    clickEvent.currentTarget.nextSibling.innerText = counter;
}

function decrease(clickEvent){
    let counter = parseInt(clickEvent.currentTarget.previousSibling.innerText);
    if(counter !== 0) {
        counter -= 1;
    }else{
        counter = 0;
    }
    clickEvent.currentTarget.previousSibling.innerText = counter;
}

function init(){
    addButton.forEach(element => {
        element.addEventListener('click', addToCart);
    });
}

init();