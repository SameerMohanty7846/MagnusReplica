<%@ page
	import="com.magnus.service.DisplayService,java.util.ArrayList,com.magnus.bean.RetrievedUserInfoBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<title>Document</title>
<style>
section {
	height: 80%;
	width: 100%;
}

.container-1 {
	display: flex;
}

.container-1 input {
	width: 300px;
}

.btn-edit {
	background-color: green;
	color: white;
}

.btn-delete {
	background-color: red;
	color: white;
}

th {
	cursor: pointer;
}
</style>

</head>
<body>
	<section>
		<main>
			

			<div class="container">
				<table class="table  table-bordered table-hover p-3" 
					style="margin-left: -80px;" id="myTable">

					<thead>
						<tr>
							<th onclick="sortTable(0)">First Name</th>
							<th onclick="sortTable(1)">Last Name</th>
							<th onclick="sortTable(2)" style="width: 180px;">Mobile No</th>
							<th onclick="sortTable(3)">Email Id</th>
							<th onclick="sortTable(4)">Gender</th>
							<th onclick="sortTable(5)" style="width: 150px;">Birth Date</th>
							<th onclick="sortTable(6)">Country</th>
							<th onclick="sortTable(7)" style="width: 150px;">City</th>
							<th>Action</th>
						</tr>
					</thead>
					<%
			
			ArrayList<RetrievedUserInfoBean> al = (	ArrayList<RetrievedUserInfoBean>)request.getAttribute("arraylist");
			%>
					<tbody>

						<%
						for (RetrievedUserInfoBean ob : al) {
						%>
						<tr>
							<td>
								<%=
								ob.getFirstName()
								%>
							</td>
							<td>
								<%=
								ob.getLastName()
								%>
							</td>
							<td>
								<%=
								ob.getMobile()
								%>
							</td>
							<td>
								<%=
								ob.getEmail()
								%>
							</td>
							<td>
								<%=
								ob.getGender()
								%>
							</td>
							<td>
								<%=
								ob.getDob()
								%>
							</td>
							<td>
								<%=
								ob.getCountry()
								%>
							</td>
							<td>
								<%=
								ob.getCity()
								%>
							</td>
							<td style="display: flex; justify-content: space-around;">
								<form action="EditServlet">
									<%
									String email = ob.getEmail();
									%>
									<input type="hidden" name="email" value="<%=email%>">
									<button class="btn btn-success btn-sm" type="submit">Edit</button>
								</form>
								<form action="DeleteServlet">
									<input type="hidden" name="email" value="<%=email%>">
									<button class="btn btn-danger btn-sm" type="submit">Delete</button>
								</form>

							</td>


						</tr>

						<%
						}
						%>
					</tbody>
				</table>

				<script>
                let currentSortColumn = -1;
                let sortOrder = 'asc';
        
                function sortTable(columnIndex) {
                    const table = document.getElementById('myTable');
                    const tbody = table.querySelector('tbody');
                    const rowsArray = Array.from(tbody.getElementsByTagName('tr'));
                    const isAscending = currentSortColumn === columnIndex ? sortOrder === 'asc' : true;
                    const compare = (a, b) => {
                        const textA = a.children[columnIndex].textContent.trim();
                        const textB = b.children[columnIndex].textContent.trim();
        
                        return isAscending
                            ? textA.localeCompare(textB)
                            : textB.localeCompare(textA);
                    };
        
                    rowsArray.sort((a, b) => compare(a, b));
        
                    rowsArray.forEach(row => tbody.appendChild(row));
        
                    document.querySelectorAll('th').forEach(th => th.classList.remove('sort-asc', 'sort-desc'));
        
                    if (isAscending) {
                        table.querySelectorAll('th')[columnIndex].classList.add('sort-asc');
                        sortOrder = 'desc';
                    } else {
                        table.querySelectorAll('th')[columnIndex].classList.add('sort-desc');
                        sortOrder = 'asc';
                    }
        
                    currentSortColumn = columnIndex;
                }
            </script>

			</div>



		</main>
	</section>
</body>
</html>