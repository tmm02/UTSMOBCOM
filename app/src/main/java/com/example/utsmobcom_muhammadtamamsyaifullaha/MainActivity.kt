import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.example.utsmobcom_muhammadtamamsyaifullaha.R


data class MataKuliah(val nama: String, val icon: Int, val sks: Int)

val mataKuliahList = listOf(
    MataKuliah("Mata Kuliah 1", R.drawable.unj, 3),
    MataKuliah("Mata Kuliah 2", R.drawable.unj, 4),
    MataKuliah("Mata Kuliah 3", R.drawable.unj, 4),
    MataKuliah("Mata Kuliah 4", R.drawable.unj, 4),
    MataKuliah("Mata Kuliah 5", R.drawable.unj, 3),
    MataKuliah("Mata Kuliah 6", R.drawable.unj, 3),
    MataKuliah("Mata Kuliah 7", R.drawable.unj, 2),
    MataKuliah("Mata Kuliah 8", R.drawable.unj, 3),
    MataKuliah("Mata Kuliah 9", R.drawable.unj, 2),
    MataKuliah("Mata Kuliah 10", R.drawable.unj, 4),
)

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
                TabelMataKuliah(mataKuliahList)
        }
    }
}

@Composable
fun TabelMataKuliah(mataKuliahList: List<MataKuliah>) {
    LazyVerticalGrid(
        columns =GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(mataKuliahList) { mataKuliah ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp),
            ) {
                Image(
                    painter = painterResource(id = mataKuliah.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Text(text = mataKuliah.nama, fontWeight = FontWeight.Bold)
                Text(text = "SKS: ${mataKuliah.sks}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTabelMataKuliah() {
        TabelMataKuliah(mataKuliahList)
}
