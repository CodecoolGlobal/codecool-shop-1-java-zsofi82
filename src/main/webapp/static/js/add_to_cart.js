const categoryList = document.querySelectorAll('.category-list');
const container = document.querySelector('#container');
const addButton = document.querySelectorAll('#addButton');
const cartButton = document.querySelector('#cartButton');

async function addToCart(clickEvent) {
    const heroId = clickEvent.currentTarget.dataset.eventId;
    const productSelectorElement = document.querySelector(`select[data-event-id="${heroId}"]`);
    await apiPut('/api/order', productSelectorElement.value, 1, heroId);
}

async function apiPut(url, productId, quantity, heroId) {
    await fetch(url, {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                productID: productId,
                quantity: quantity,
                heroID: heroId
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

async function createTBody() {
    container.innerHTML = "";
    let data = await apiGet('/api/order');

    data.orderitems.forEach(element => {
        const tr = document.createElement('tr');
        const heroNameTd = document.createElement('td');
        const productNameTd = document.createElement('td');
        const quantityTd = document.createElement('td');
        const plusBtn = document.createElement("button");
        const minusBtn = document.createElement("button");
        let counterSpan = document.createElement("span");

        const heroName = findItem(data.heroes, element.heroID).name;
        const productName = findItem(data.productcategories, element.productID).name;
        const quantity = element.quantity;

        const orderId = `${element.heroID};${element.productID}`;
        plusBtn.dataset.orderId = orderId;
        minusBtn.dataset.orderId = orderId;
        counterSpan.dataset.orderId = orderId;
        plusBtn.classList.add('btn', 'btn-primary');
        minusBtn.classList.add('btn', 'btn-primary');

        heroNameTd.innerText = heroName;
        productNameTd.innerText = productName;
        plusBtn.innerText = "+";
        minusBtn.innerText = "-";
        counterSpan.innerText = quantity;

        plusBtn.addEventListener('click', increase);
        minusBtn.addEventListener('click', decrease);

        quantityTd.append(plusBtn, counterSpan, minusBtn);
        tr.append(heroNameTd, productNameTd, quantityTd);
        container.appendChild(tr);
    });
}

function findItem(collection, itemId) {
    return collection.filter(item => itemId === item.id)[0];
}

function increase(clickEvent) {
    const orderId = clickEvent.currentTarget.dataset.orderId;
    const counterElement = document.querySelector(`span[data-order-id="${orderId}"]`);
    counterElement.innerText = parseInt(counterElement.innerText) + 1;
}

function decrease(clickEvent) {
    const orderId = clickEvent.currentTarget.dataset.orderId;
    const counterElement = document.querySelector(`span[data-order-id="${orderId}"]`);
    const counter = parseInt(counterElement.innerText);
    if (counter !== 0) {
        counterElement.innerText = counter - 1;
    } else {
        counterElement.innerText = "0";
    }

}

function init() {
    addButton.forEach(element => {
        element.addEventListener('click', addToCart);
    });

    cartButton.addEventListener('click', createTBody);
}

init();