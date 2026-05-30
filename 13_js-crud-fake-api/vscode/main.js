const BASE_URL_SERVER_FAKE_API = "https://fakestoreapi.com/products";


/**
 * =====================
 * # GET METHOD
 * =====================
 */
const htmlBtn1GetAll = document.getElementById("btn1-getall");
const htmlBtn1GetByID = document.getElementById("btn1-getbyid");
const htmlGetArea1 = document.querySelector(".get-area1");
const htmlGetArea2 = document.querySelector(".get-area2");

async function getAllProducts() {
  try {
    const response = await fetch(BASE_URL_SERVER_FAKE_API);
    if(!response.ok) {
      throw new Error('Network response was not ok!');
    }
    const data = await response.json();
    return data;
  }
  catch(error) {
    console.error("Error: ", error);
  }
}

async function getProductByID(id) {
  try {
    if(id == "" || id == null) {
      alert("Value of ID is empty");
      return null;
    }
    const response = await fetch(BASE_URL_SERVER_FAKE_API+`/${id}`);
    if(!response.ok) {
      throw new Error('Network response was not ok!');
    }
    return await response.json();
  }
  catch(error) {
    console.error("Error: ", error);
  }
}

htmlBtn1GetAll.addEventListener("click", async () => {
  try {
    const allProducts = await getAllProducts();

    if(allProducts) {
      allProducts.forEach(element => {
        console.log(JSON.stringify(element));
        const { id, title, price, description } = element;

        const newElement = document.createElement('div');
        newElement.innerHTML = `
          <p>Id : ${id}</p>
          <p>Title : ${title}</p>
          <p>Price : ${price}</p>
          <p>Desc : ${description}</p>
        `;

        htmlGetArea1.appendChild(newElement);
      });
    }
    else {
      htmlGetArea1.innerHTML = `<p>Failed to get all data products</p>`;
    }
  }
  catch(error) {
    htmlGetArea1.innerHTML = `<pre>${error}</pre>`;
  }
});

htmlBtn1GetByID.addEventListener('click', async () => {
  try {
    const htmlProductIDValue = document.getElementById("product-id").value;
    console.log(htmlProductIDValue);
    const productByID = await getProductByID(htmlProductIDValue);
    
    if(productByID) {
      const { id, title, price, description } = productByID;
      
      const newElement = document.createElement('div');
      newElement.innerHTML = `
      <p>Id : ${id}</p>
      <p>Title : ${title}</p>
      <p>Price : ${price}</p>
      <p>Desc : ${description}</p>
      `;
      
      htmlGetArea2.appendChild(newElement);
    }
    else {
      htmlGetArea2.innerHTML = `<p>Failed to get product by ID</p>`;
    }
  }
  catch(error) {
    htmlGetArea2.innerHTML = `<pre>${error}</pre>`;
  }
});

/**
 * =====================
 * # POST METHOD
 * =====================
 */
const htmlBtn2PostProduct = document.getElementById("btn2-postproduct");
const htmlPostArea1 = document.querySelector(".post-area1");

async function postProduct(product) {
  try {
    const response = await fetch(BASE_URL_SERVER_FAKE_API, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product),
    });

    const completeResponse = {
      code: response.status,
      headers: response.headers.get('content-type'),
      data: await response.json(),
    };
    
    if(!response.ok) {
      throw new Error('Network response was not ok!');
    }

    return await completeResponse;
  }
  catch(error) {
    console.error("Error: ", error);
  }
}

htmlBtn2PostProduct.addEventListener('click', async () => {
  // Get data from form
  const formTitle = document.getElementById("p-title").value;
  const formPrice = document.getElementById("p-price").value;
  const formDesc = document.getElementById("p-desc").value;
  const formCategory = document.getElementById("p-category").value;
  const formImage = document.getElementById("p-image").value;

  const newProduct = {
    title: formTitle,
    price: parseFloat(formPrice),
    description: formDesc,
    category: formCategory,
    image: formImage,
  };

  const { code, headers, data } = await postProduct(newProduct);
  const { id, title, price, description, category, image } = data;
  console.log(data);

  const newElemenDataSend = document.createElement('div');
  newElemenDataSend.innerHTML = `
    <p>Code : ${code}</p>
    <p>Headers : ${headers}</p>
    <p>Id : ${id}</p>
    <p>Title : ${title}</p>
    <p>Price : ${price}</p>
    <p>Desc : ${description}</p>
    <p>Category : ${category}</p>
    <p>Image : ${image}</p>
  `;
  htmlPostArea1.appendChild(newElemenDataSend);
});


/**
 * =====================
 * # PUT/PATCH METHOD   
 * =====================
 */

// Get By ID untuk data yang akan di update, kita tampilkan di html form
const htmlGetIDProductUpdate = document.getElementById("btn3-getbyid");
const htmlBtn3Update = document.getElementById("btn3-update");
const htmlGetArea3 = document.querySelector(".get-area3");

const formTitle = document.getElementById("update-p-title");
const formPrice = document.getElementById("update-p-price");
const formDesc = document.getElementById("update-p-desc");
const formCategory = document.getElementById("update-p-category");
const formImage = document.getElementById("update-p-image");

let htmlIDProductUpdateValue = null;

async function putProduct(product) {
  try {
    const response = await fetch(BASE_URL_SERVER_FAKE_API+`/${product.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(product),
    });

    const completeResponse = {
      code: response.status,
      headers: response.headers.get('content-type'),
      data: await response.json(),
    };
    
    if(!response.ok) {
      throw new Error('Network response was not ok!');
    }

    return await completeResponse;
  }
  catch(error) {
    console.error("Error: ", error);
  }
}

htmlGetIDProductUpdate.addEventListener('click', async () => {
  try {
    htmlIDProductUpdateValue = document.getElementById("update-product-id").value;

    const productByIDUpdate = await getProductByID(htmlIDProductUpdateValue);
    const { id, title, price, description, category, image } = productByIDUpdate;

    if(productByIDUpdate) {
      formTitle.value = title;
      formPrice.value = price;
      formDesc.value = description;
      formCategory.value = category;
      formImage.value = image;
    }
    else {
      alert("Failed to get data");
    }
  }
  catch(error) {
    alert(error);
  }
});

htmlBtn3Update.addEventListener('click', async () => {
  try {
    const dataProductUpdate = {
      id: htmlIDProductUpdateValue,
      title: formTitle.value,
      price: formPrice.value,
      description: formDesc.value,
      category: formCategory.value,
      image: formImage.value
    };

    console.log(`Update : ${JSON.stringify(dataProductUpdate)}`);
    const responseUpdate = putProduct(dataProductUpdate);

    if(responseUpdate) {
      const newElement = document.createElement('div');
      newElement.innerHTML = `
        <p>Id : ${htmlIDProductUpdateValue}</p>
        <p>Title : ${formTitle.value}</p>
        <p>Price : ${formPrice.value}</p>
        <p>Desc : ${formDesc.value}</p>
        <p>Category : ${formCategory.value}</p>
        <p>Image : ${formImage.value}</p>
      `;

      htmlGetArea3.appendChild(newElement);
    }
    else {
      alert("Failed update product");
    }
  }
  catch(error) {
    alert(error);
  }
});


/**
 * =====================
 * # DELETE METHOD   
 * =====================
 */
const htmlBtn4DeleteByID = document.getElementById("btn4-deletebyid");
const htmlDeleteArea4 = document.querySelector(".delete-area4");

let htmlDeleteProductID = null;

async function deleteProductByID(id) {
  try {
    const response = await fetch(BASE_URL_SERVER_FAKE_API+`/${id}`, {
      method: "DELETE"
    });
    if(!response.ok) {
      throw new Error('Network response was not ok!');
    }
    return await response.json();
  }
  catch(error) {
    console.error("Error: ", error);
  }
}

htmlBtn4DeleteByID.addEventListener('click', async () => {
  try {
    htmlDeleteProductID = document.getElementById("delete-product-id").value;
    const productDeleteByID = await getProductByID(htmlDeleteProductID);
    const resultDelete = await deleteProductByID(htmlDeleteProductID);

    if(resultDelete) {
      const { id, title, price, description, category, image } = productDeleteByID;
      const newElement = document.createElement('div');
      newElement.innerHTML = `
        <p>Data Product that deleted...</p>
        </br>
        <p>Id : ${id}</p>
        <p>Title : ${title}</p>
        <p>Price : ${price}</p>
        <p>Desc : ${description}</p>
        <p>Category : ${category}</p>
        <p>Image : ${image}</p>
      `;
      htmlDeleteArea4.appendChild(newElement);
    }
    else {
      alert("Error delete data");
    }
  }
  catch(error) {
    console.log(error);
  }
});


/**
 * ## class result-area
 * Disini untuk area hasil response
 * - collapsible : agar bisa di buka tutup
 * - hightStyle : agar tinggi bisa otomatis menyesuaikan isi konten
 */
$(function() {
  $(".result-area").accordion({
    collapsible: true,
    heightStyle: "content",
  });
});


